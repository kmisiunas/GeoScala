package com.misiunas.geoscala.transformations

import breeze.linalg.DenseMatrix
import com.misiunas.geoscala.Point

/**
 * User: karolis@misiunas.com
 * Date: 11/08/2013
 * Time: 19:21
 */
trait Rotations[T<:Rotations[T]] extends LinearTransformations[T]{
  this: T =>

  /** rotates the object around Z axis */
  def rotateAroundZ(rad: Double): T = {
    val r = DenseMatrix.zeros[Double](3,3)
    r.update( (0,0), math.cos(rad) )
    r.update( (0,1), -math.sin(rad) )
    r.update( (1,0), math.sin(rad) )
    r.update( (1,1), math.cos(rad) )
    r.update( (2,2), 1.0 )
    transform(r)
  }

  /** rotates the object around Y axis */
  def rotateAroundY(rad: Double): T = {
    val r = DenseMatrix.zeros[Double](3,3)
    r.update( (0,0), math.cos(rad) )
    r.update( (2,0), -math.sin(rad) )
    r.update( (0,2), math.sin(rad) )
    r.update( (2,2), math.cos(rad) )
    r.update( (1,1), 1.0 )
    transform(r)
  }

  /** rotates the object around X axis */
  def rotateAroundX(rad: Double): T = {
    val r = DenseMatrix.zeros[Double](3,3)
    r.update( (1,1), math.cos(rad) )
    r.update( (1,2), -math.sin(rad) )
    r.update( (2,1), math.sin(rad) )
    r.update( (2,2), math.cos(rad) )
    r.update( (0,0), 1.0 )
    transform(r)
  }

  /** rotates in spherical cylindrical coordinate system */
  def rotate(phi: Double, theta: Double): T = ???

}
