package com.misiunas.geoscala.surfaces

import com.misiunas.geoscala.{Line, Point, Feature}
import com.misiunas.geoscala.transformations.GeometricTransformations

/**
 * User: karolis@misiunas.com
 * Date: 10/08/2013
 * Time: 21:47
 */
class Plane private (val p1: Point, val p2: Point, val p3: Point) extends Feature with GeometricTransformations[Plane] {

  def distance(p: Point): Double = ???

  def getPoints: List[Point] = List(p1,p2,p3)
  def constructFromPoints(list: List[Point]): Plane = Plane(list)


  def intersection(l: Line): Point = ???

}

object Plane {
  def apply(p1: Point, p2: Point, p3: Point): Plane = new Plane(p1,p2,p3)
  def apply(list: List[Point]): Plane = {
    if (list.size == 3) apply(list(0), list(1), list(2))
    else throw new IllegalArgumentException("Plane needs exactly 3 Points to be constructed")
  }

  def getXY(atZ: Double = 0): Plane = apply(Point(0,0, atZ), Point(1,0,atZ), Point(0,1,atZ) )
}

