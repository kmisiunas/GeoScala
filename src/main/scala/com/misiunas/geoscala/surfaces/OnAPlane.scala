package com.misiunas.geoscala.surfaces

/**
 * User: karolis@misiunas.com
 * Date: 10/08/2013
 * Time: 21:47
 */
trait OnAPlane extends Surface {

  /** get plane that this object lies on */
  def getPlane: Plane

  // todo projections

}
