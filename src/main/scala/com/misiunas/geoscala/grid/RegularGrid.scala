package com.misiunas.geoscala.grid

import com.misiunas.geoscala.Point

/**
 * == Grid that has regular element spacing ==
 *
 * User: karolis@misiunas.com
 * Date: 21/08/2013
 * Time: 14:41
 */
trait RegularGrid[A] extends Grid[A] {

  def spacing: Point



}
