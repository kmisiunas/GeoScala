package com.misiunas.geoscala.transformations

import com.misiunas.geoscala.Point

/**
 * == Ensures that it is possible to decompose geometrical feature to list of Points and back ==
 *
 * User: karolis@misiunas.com
 * Date: 11/08/2013
 * Time: 16:55
 */
trait PointDecomposition[T <: PointDecomposition[T]] extends AnyRef {
  this: T =>

  /** gets a list of points that defines the shape - order matters */
  def getPoints: List[Point]

  /** The shape can be constructed from ordered list of points */
  def constructFromPoints(list: List[Point]): T

  override def equals(a: Any): Boolean = a match {
    case pd: PointDecomposition[T] => this.getPoints == pd.getPoints // not sure if this is the best method, as it uses T
    case _ => false
  }

}
