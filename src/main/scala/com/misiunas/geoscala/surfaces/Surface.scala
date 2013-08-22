package com.misiunas.geoscala.surfaces

import com.misiunas.geoscala.{Point, Feature}
import com.misiunas.geoscala.vectors.Vec
import com.misiunas.geoscala.DoubleWithAlmostEquals

/**
 * == A surface ==
 *
 *
 * User: karolis@misiunas.com
 * Date: 10/08/2013
 * Time: 21:30
 */
trait Surface extends Feature {

  def isWithin(p: Point): Boolean = distance(p) ~== 0.0 // approximate for long manipulations

  def normal: Vec

}
