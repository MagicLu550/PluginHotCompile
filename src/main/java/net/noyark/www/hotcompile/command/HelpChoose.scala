package net.noyark.www.hotcompile.command

import net.noyark.www.hotcompile.HotCompile

class HelpChoose(name: String) extends Choose(name : String) {

  override def execute(str: String): Boolean = {
    HotCommandCompiler.map.foreach{
      t=>HotCompile.getHotCompile.getLogger.info(t._1+" : "+ t._2.getName)
    }
    true
  }
}
