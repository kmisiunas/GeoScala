package com.misiunas.geoscala.transformations

import com.misiunas.geoscala.Point

/**
 * User: karolis@misiunas.com
 * Date: 11/08/2013
 * Time: 19:24
 */
trait Translations[T <: Translations[T]] extends LinearTransformations[T] {
  this: T =>

  /** will move a geometrical object alon the cartesian coordinates */
  def move(x: Double, y:Double, z:Double = 0): T = transform( _ + Point(x,y,z) )



}
