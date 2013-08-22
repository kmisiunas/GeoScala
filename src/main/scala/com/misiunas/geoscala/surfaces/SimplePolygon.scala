package com.misiunas.geoscala.surfaces

import com.misiunas.geoscala.{Line, Point}
import com.misiunas.geoscala.vectors.Vec

/**
 * User: karolis@misiunas.com
 * Date: 21/08/2013
 * Time: 16:55
 */
trait SimplePolygon extends OnAPlane with Surface {

  /** get all vertices */
  def vertices: List[Point]

  // ------ Implemented methods --------

  def lines: List[Line] = {
    val v = vertices
    v.zip( v.tail :+ v.head).map(pp => Line(pp._1, pp._2))
  }

  lazy val normal: Vec = getPlane.normal
  def getPlane: Plane = Plane(vertices.take(3))

  // Expensive due to universal construction
  def distance(p: Point): Double = {
    val onPlane = getPlane.project(p)
    val lines = this.lines
    // is the projection within the polygon
    if ( lines.forall(line => (line.toVec cross onPlane dot normal) > 0) ){ // not sure if this is the right direction
      getPlane.distance(p)
    } else { // projection outside the polygon - closet to the lines
      lines.map(_.distance(p)).min
    }
  }

}
