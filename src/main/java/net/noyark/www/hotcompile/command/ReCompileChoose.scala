package net.noyark.www.hotcompile.command

import java.io.File

import net.noyark.www.hotcompile.{HotCompile, JavaCompiler}

class ReCompileChoose(name: String) extends Choose(name: String){

  override def execute(str: String): Boolean = {
    JavaCompiler.hotCompile(new File(HotCompile.getHotCompile.getDataFolder+"/"+str),HotCompile.getHotCompile)
    true
  }
}
