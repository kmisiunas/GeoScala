package com.misiunas.geoscala.surfaces

import com.misiunas.geoscala.transformations.GeometricTransformations
import com.misiunas.geoscala.{Point, DoubleWithAlmostEquals}


/**
 * == A Rectangle ==
 * User: karolis@misiunas.com
 * Date: 21/08/2013
 * Time: 17:53
 */
class Rectangle private (override val p1: Point, override val p2: Point, override val p3: Point) extends Rhombus (p1,p2,p3)
  with GeometricTransformations[Rectangle] {

}

object Rectangle {

  /** constructor checks if right angles were satisfied */
  def apply(p1: Point, p2: Point, p3: Point): Rectangle = {
    if( (p2 - p1) angle (p3 - p1) ~== Math.PI/2) new Rectangle(p1,p2,p3)
    else throw new RuntimeException("Rectangle must have right corners. The specified was ")
  }

  // todo: other more convient methods for creating rectangles

}
