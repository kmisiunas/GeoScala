package com.misiunas.geoscala.vectors

import com.misiunas.geoscala.Point

/**
 * == Simple 3D vector representation ==
 *
 * For full featured vector representation use [[http://www.scalanlp.org/ Breeze]].
 * Where possible this will be compatible with Breeze.
 *
 * Name chosen "Vec" not to overlap with Vector in scala API
 *
 * User: karolis@misiunas.com
 * Date: 10/08/2013
 * Time: 21:52
 */
class Vec protected (val x: Double, val y: Double, val z: Double) extends Vector3DLike{

  protected type That = Vec

  override def toString = "Vec("+x+", "+y+", "+z+")"

  protected def makeFrom(e1: Double, e2: Double, e3: Double): Vec = new Vec(e1,e2,e3)

  def toPoint: Point = Point(x,y,z)

}

object Vec {
  def apply(x:Double, y:Double, z:Double): Vec = new Vec(x,y,z)
  def apply(x:Double, y:Double): Vec = new Vec(x,y,0)
  def apply(x:Double): Vec = new Vec(x,0,0)

  implicit def vec2Point(p:Vec): Point = p.toPoint

}
