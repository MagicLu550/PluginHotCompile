package net.noyark.www.hotcompile.command

import cn.nukkit.command.{Command, CommandSender}
import net.noyark.www.hotcompile.HotCompile


object HotCommandCompiler {

  private val MMap = scala.collection.mutable.Map
  val map = MMap[String,Choose](
    "about" -> new AboutChoose("用于打开关闭开启服务器时的关于 true/false"),
          "recompile" -> new ReCompileChoose("用于重新编译打包加载某个文件夹的java文件" +
            "参数是name 代表的路径为plugins/"+HotCompile.getHotCompile.getName+"/${name} 下的源代码"),
          "help" -> new HelpChoose("获取所有命令信息")
  )

  def execute(sender : CommandSender,command : Command,args:Array[String]) : Boolean ={
    map(command.getName).execute(if(args.length==3)args(2) else "")
  }


}
