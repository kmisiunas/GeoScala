package com.misiunas.geoscala.vectors

import com.misiunas.geoscala.Point
import breeze.linalg.DenseVector

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
class Vec protected (val x: Double, val y: Double, val z: Double) extends Vector3DLike[Vec] {

  override def toString = "Vec("+x+", "+y+", "+z+")"

  protected def makeFrom(e1: Double, e2: Double, e3: Double): Vec = new Vec(e1,e2,e3)

  // ------ Convenient conversions -----------

  def toPoint: Point = Point(x,y,z)

  def toVec: Vec = Vec(x,y,z)

}

object Vec  {
  protected def makeFrom(e1: Double, e2: Double, e3: Double): Vec = new Vec(e1,e2,e3)

  implicit def vec2Point(p:Vec): Point = p.toPoint

  implicit def fromDenseVector(dv: DenseVector[Double]): Vec = apply(dv.toArray)

  // tmp fix:
  type T = Vec
  def apply(x:Double, y:Double, z:Double): T = makeFrom(x,y,z)
  def apply(x:Double, y:Double): T = makeFrom(x,y,0)
  def apply(x:Double): T = makeFrom(x,0,0)
  def apply(ar:Array[Double]): T =
    if (ar.size == 3) makeFrom(ar(0), ar(1), ar(2))
    else throw new IllegalArgumentException("Vec(array) size of array must be 3")

}

