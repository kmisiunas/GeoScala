package com.misiunas.geoscala

import com.misiunas.geoscala.vectors.{Vector3DLikeObj, Vector3DLike, Vec}
import com.misiunas.geoscala.transformations.GeometricTransformations

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
  Vec (x,y,z) with Feature  with GeometricTransformations[Point] {

  override protected def makeFrom(e1: Double, e2: Double, e3: Double): Point = new Point(e1,e2,e3)

  override def toString = "Point("+x+", "+y+", "+z+")"

  // --- other implementations ---

  def distance(that: Point): Double = (this - that).vectorLength

  def getPoints: List[Point] = List(this)
  def constructFromPoints(list: List[Point]): Point = list.head
}

object Point  extends Vector3DLikeObj[Point] {
  protected def makeFrom(e1: Double, e2: Double, e3: Double): Point = new Point(e1,e2,e3)
}
