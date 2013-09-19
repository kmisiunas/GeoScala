package com.misiunas.geoscala.surfaces

import com.misiunas.geoscala.transformations.GeometricTransformations
import com.misiunas.geoscala.{Point, DoubleWithAlmostEquals}


/**
 * == A Rectangle ==
 * User: karolis@misiunas.com
 * Date: 21/08/2013
 * Time: 17:53
 */
class Rectangle protected (override val p1: Point, override val p2: Point, override val p3: Point)
  extends Rhombus (p1,p2,p3) {

  override def constructFromPoints(l: List[Point]): Rectangle = Rectangle(l(0),l(1),l(2))

}

object Rectangle {

  /** constructor checks if right angles were satisfied */
  def apply(p1: Point, p2: Point, p3: Point): Rectangle = {
    if( (p2 - p1) angle (p3 - p1) ~== Math.PI/2) new Rectangle(p1,p2,p3)
    else throw new RuntimeException("Rectangle must have right corners. The specified was ")
  }

  def xy(p: Point, width: Double, height: Double, placement: String = "corner"): Rectangle = {
    placement.toLowerCase match {
      case "corner" => Rectangle( p, p + Point(0, height, 0), p + Point(width, height, 0)) // bottom left corner
      case "center" => Rectangle( p + Point(-width/2, -height/2, 0), p + Point(-width/2, height/2, 0), p + Point(width/2, height/2, 0))
      case _ => throw new RuntimeException("Did not recognise placement procedure: " + placement)
    }
  }


  // todo: other more convent methods for creating rectangles

}
