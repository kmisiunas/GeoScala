package com.misiunas.geoscala

import com.misiunas.geoscala.vectors.{Vector3DLike, Vec}

//import _root_.breeze.linalg.DenseVector

/**
 * == A point in 3D space ==
 *
 * This is a 3D vector
 *
 * todo: add vector library or make it compatible with Breeze
 *
 * User: karolis@misiunas.com
 * Date: 10/08/2013
 * Time: 21:21
 */
class Point protected (override val x: Double, override val y:Double, override val z:Double) extends
  Vector3DLike with Feature {

  protected type That = Point

  protected def makeFrom(e1: Double, e2: Double, e3: Double): Point = new Point(e1,e2,e3)

  override def toString = "Point("+x+", "+y+", "+z+")"

  def toVec: Vec = Vec(x,y,z)

  def distance(that: Point): Double = (this - that).vectorLength

}

object Point {
  def apply(x:Double, y:Double, z:Double) : Point = new Point(x,y,z)
  def apply(x:Double, y:Double) : Point = new Point(x,y,0)
  def apply(x:Double) : Point = new Point(x,0,0)

  implicit def point2Vec(p:Point): Vec = p.toVec
}
