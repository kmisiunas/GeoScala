package com.misiunas.geoscala.surfaces

import com.misiunas.geoscala.{Point, Feature}
import com.misiunas.geoscala.transformations.GeometricTransformations
import com.misiunas.geoscala.vectors.Vec

/**
 * == A representation of a rectangle ==
 *
 * User: karolis@misiunas.com
 * Date: 21/08/2013
 * Time: 16:05
 */
class Rhombus protected (val p1: Point, val p2: Point, val p3: Point) extends SimplePolygon
  with GeometricTransformations[Rhombus] {

  /** point determined by right angles */
  def p4: Point = p1 + (p3 - p2)

  def getPoints: List[Point] = List(p1,p2,p3,p4)
  def constructFromPoints(l: List[Point]): Rhombus = Rhombus(l(0),l(1),l(2))

  /** get all vertices */
  def vertices: List[Point] = getPoints

  override def toString: String = "Rhombus( " + this.getPoints.mkString(", ") +")"

}

object Rhombus {

  def apply(p1: Point, p2: Point, p3: Point): Rhombus = new Rhombus(p1,p2,p3)


}
