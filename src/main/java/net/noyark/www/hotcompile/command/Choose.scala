package net.noyark.www.hotcompile.command

abstract class Choose(name : String) {

  def execute(str : String) : Boolean

  def getName = name
}
