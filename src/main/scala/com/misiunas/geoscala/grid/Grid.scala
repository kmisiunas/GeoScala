package com.misiunas.geoscala.grid

import com.misiunas.geoscala.Point

/**
 * == Grid on the landscape ==
 * User: karolis@misiunas.com
 * Date: 21/08/2013
 * Time: 14:37
 */
trait Grid[A] {

  def apply(p: Point): A

  protected def findBin(d: Double* )

}
