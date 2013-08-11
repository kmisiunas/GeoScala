package com.misiunas.geoscala

/**
 * == A geometrical line ==
 *
 *
 * User: karolis@misiunas.com
 * Date: 10/08/2013
 * Time: 21:43
 */
class Line private (val p1: Point, val p2: Point) extends Feature {

  def distance(p: Point): Double = {
    // more complex as it is not infinite line => have to check the ends first
    if( ((p - p1) dot (p2 - p1)) <= 0 ) return (p - p1).vectorLength
    if( ((p - p2) dot (p1 - p2)) <= 0 ) return (p - p2).vectorLength
    // point distance to a line
    return (p - p1).vectorLength - ((p - p1) dot (p2 - p1).normalise)
  }
}

object Line{
  def apply(p1: Point, p2: Point) = new Line(p1,p2)
}