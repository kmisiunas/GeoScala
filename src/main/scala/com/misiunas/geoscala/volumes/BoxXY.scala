package com.misiunas.geoscala.volumes

import com.misiunas.geoscala.Point
import com.misiunas.geoscala.surfaces.Rectangle
import com.misiunas.geoscala.transformations.CartesianSpaceObject

/**
 * == A 2D rectangle on XY plane, where Z coordinate is projected all along Z, thus an infinite box ==
 *
 * @param rect is the parameter where the rectangle on XY plane is stored
 *
 * Aims:
 *  - efficiency
 *
 * User: karolis@misiunas.com
 * Date: 21/08/2013
 * Time: 16:03
 */
class BoxXY private (val rect: Rectangle) extends Volume  with CartesianSpaceObject[BoxXY]{

  // slow implementations - improve
  def isWithin(p: Point): Boolean = rect.isWithin( Point(p.x,p.y,0) )
  def distance(p: Point): Double = rect.distance( Point(p.x,p.y,0) )

  def overlaps(v: Volume): Boolean = ???


  def getPoints: List[Point] = rect.getPoints

  /** The shape can be constructed from ordered list of points */
  def constructFromPoints(list: List[Point]): BoxXY = new BoxXY( rect.constructFromPoints(list) )

  override def toString: String = "BoxXY( " + this.getPoints.mkString(", ") +")"
}

object BoxXY {

  def apply(p: Point, width: Double, height: Double, placement: String = "corner"):BoxXY =  {
    new BoxXY( Rectangle.xy(Point(p.x,p.y,0), width, height, placement) )
  }

  def apply(p1: Point, p2: Point): BoxXY = BoxXY.apply(p1, (p2 - p1).x, (p2 - p1).y,  "corner")

}