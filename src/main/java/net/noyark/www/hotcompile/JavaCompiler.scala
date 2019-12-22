package net.noyark.www.hotcompile

import java.io.File

import cn.nukkit.plugin.PluginBase
import javax.tools.ToolProvider
import net.noyark.www.hotcompile.devjar.DevJar

object JavaCompiler {

    private val compiler = ToolProvider.getSystemJavaCompiler

    //文件夹目录
    private def compile(file: File,root : File): Unit ={
        if(file.isDirectory){
            //如果是文件夹，则执行编译
            val files = file.listFiles()

            for(f <- files) {
                if(!f.isDirectory) {
                    if (f.toString.endsWith(".java")) {
                        var out = new File(getOutPath(file,root))
                        if(!out.exists())out.mkdirs()
                        compiler.run(null,
                            null,
                            null,
                            "-d",
                            out.toString,
                            f.toString
                        )
                    }
                }else{
                    compile(f,root)
                }
            }
        }
    }



    def compile(file:File):Unit = compile(file,file)


    def hotCompile(f: File,plugin:PluginBase) : Unit = {
      JavaCompiler compile f
      val outRoot = JavaCompiler getOutRootPath f
      val jarFile = plugin.getDataFolder.getParentFile+outRoot.getName+".hotcompile.jar"
      DevJar.devJar(outRoot.toString,jarFile) //打包
      plugin.getPluginLoader.loadPlugin(jarFile) //加载
    }

    def getClassPath(file:File,rootFile:File)=file.toString.replace(rootFile.toString,"")

    def getOutPath(file:File,root : File) = getOutRootPath(root)+getClassPath(file,root)

    def getOutRootPath(root: File) = new File(HotCompile.getHotCompile.getDataFolder+"/"+root.getName+".out")

}
