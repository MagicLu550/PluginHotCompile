package net.noyark.www.hotcompile.command

import net.noyark.www.hotcompile.HotCompile

class AboutChoose(name: String) extends Choose(name: String) {

  override def execute(str : String): Boolean = {
    //stop关闭信息
    HotCompile.getHotCompile.getConfig.set("about",str)
    HotCompile.getHotCompile.saveConfig()
    true
  }
}
