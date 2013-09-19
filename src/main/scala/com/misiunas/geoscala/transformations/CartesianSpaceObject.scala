package com.misiunas.geoscala.transformations

import com.misiunas.geoscala.Point
import com.misiunas.geoscala.vectors.Vec

/**
 * User: karolis@misiunas.com
 * Date: 22/08/2013
 * Time: 18:05
 */
trait CartesianSpaceObject[T <: PointDecomposition[T]] extends PointDecomposition[T] {
  this: T =>

  /** finds point confining the shape from the top */
  lazy val max: Point = {
    val points = getPoints.map(p => (p.x, p.y, p.z)).unzip3
    Point( points._1.max, points._2.max, points._3.max)
  }

  /** finds point confining the shape from the bottom */
  lazy val min: Point = {
    val points = getPoints.map(p => (p.x, p.y, p.z)).unzip3
    Point( points._1.min, points._2.min, points._3.min)
  }

  /** finds maximum variation vector */
  def range: Vec = max - min

}
