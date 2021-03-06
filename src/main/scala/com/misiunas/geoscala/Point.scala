package com.misiunas.geoscala

import com.misiunas.geoscala.vectors.{Vector3DLike, Vec}
import com.misiunas.geoscala.transformations.GeometricTransformations
import breeze.linalg.DenseVector

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
  Vec (x,y,z)  with Feature  {

  //todo: this will cause to return Vec instead of Point
  override type T = Vec

  override protected def makeFrom(e1: Double, e2: Double, e3: Double): Point = new Point(e1,e2,e3)

  override def toString: String = "Point("+x+", "+y+", "+z+")"

  // --- other implementations ---

  def distance(that: Point): Double = (this - that).vectorLength

  def getPoints: List[Point] = List(this)
  def constructFromPoints(list: List[Point]): Point = list.head

}

object Point  {

  protected def makeFrom(e1: Double, e2: Double, e3: Double): Point = new Point(e1,e2,e3)

  implicit def point2Vec(p:Point): Vec = p.toVec

  implicit def fromDenseVector(dv: DenseVector[Double]): Point = apply(dv.toArray)

  // tmp fix:
  type T = Point
  def apply(x:Double, y:Double, z:Double): T = makeFrom(x,y,z)
  def apply(x:Double, y:Double): T = makeFrom(x,y,0)
  def apply(x:Double): T = makeFrom(x,0,0)
  def apply(ar:Seq[Double]): T =
    if (ar.size == 3) makeFrom(ar(0), ar(1), ar(2))
    else throw new IllegalArgumentException("Vec(array) size of array must be 3")

  def apply(dv: DenseVector[Double]): Point = apply(dv.toArray)

}
