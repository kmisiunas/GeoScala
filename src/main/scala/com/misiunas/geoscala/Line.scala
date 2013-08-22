package com.misiunas.geoscala

import com.misiunas.geoscala.vectors.Vec
import com.misiunas.geoscala.transformations.GeometricTransformations

/**
 * == A geometrical line ==
 *
 *
 * User: karolis@misiunas.com
 * Date: 10/08/2013
 * Time: 21:43
 */
class Line private (val p1: Point, val p2: Point) extends Feature with GeometricTransformations[Line] {

  def distance(p: Point): Double = {
    // more complex as it is not infinite line => have to check the ends first
    if( ((p - p1) dot (p2 - p1)) <= 0 ) return (p - p1).vectorLength
    if( ((p - p2) dot (p1 - p2)) <= 0 ) return (p - p2).vectorLength
    // point distance to a line
    (p - p1).vectorLength - ((p - p1) dot (p2 - p1).normalise)
  }

  def toVec: Vec = p2 - p1

  /** equation of this line */
  def toEq: Double => Point = x => direction * x + p1

  /** direction of the line - unit vector */
  def direction: Vec = toVec.normalise

  def getPoints: List[Point] = List(p1, p2)
  def constructFromPoints(list: List[Point]): Line = Line(list)

  def length = toVec.vectorLength

}

object Line{
  def apply(p1: Point, p2: Point): Line = new Line(p1,p2)
  def apply(list: List[Point]): Line = {
    if (list.size == 2) apply(list.head, list(1))
    else throw new IllegalArgumentException("Line needs exactly 2 Points to be constructed")
  }
}