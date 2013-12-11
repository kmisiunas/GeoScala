package com.misiunas.geoscala.volumes

import com.misiunas.geoscala.Point

/**
 * == Volume spanning entire space ==
 *
 * User: karolis@misiunas.com
 * Date: 10/08/2013
 * Time: 21:34
 */
class Everywhere private () extends Volume {

  def distance(p: Point): Double = 0.0

  def isWithin(p: Point): Boolean = true

  def overlaps(v: Volume): Boolean = true

  def contains(v: Volume): Boolean = true

  override def toString: String = "Everywhere(Volume)"
}

object Everywhere {
  def apply() = new Everywhere
}