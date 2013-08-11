package com.misiunas.geoscala

/**
 * == Defines A Geometrical Feature ==
 *
 * User: karolis@misiunas.com
 * Date: 10/08/2013
 * Time: 21:20
 */
trait Feature {

  /** returns the closest distance between the point and the geometrical feature */
  def distance(p: Point) : Double

}
