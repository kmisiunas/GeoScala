package com.misiunas.geoscala.transformations

/**
 * User: karolis@misiunas.com
 * Date: 11/08/2013
 * Time: 19:21
 */
trait Rotations[T<:Rotations[T]] extends LinearTransformations[T]{
  this: T =>

  /** rotates the object around Z axis */
  def rotateAroundZ(rad: Double): T = ???

  /** rotates the object around Y axis */
  def rotateAroundY(rad: Double): T = ???

  /** rotates the object around X axis */
  def rotateAroundX(rad: Double): T = ???

  /** rotates in spherical cylindrical coordinate system */
  def rotate(phi: Double, theta: Double): T = ???

}
