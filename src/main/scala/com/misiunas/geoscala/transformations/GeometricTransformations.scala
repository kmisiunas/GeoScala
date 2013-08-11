package com.misiunas.geoscala.transformations

/**
 * User: karolis@misiunas.com
 * Date: 11/08/2013
 * Time: 19:35
 */
trait GeometricTransformations[T <: GeometricTransformations[T]] extends Rotations[T] with Translations[T]{
  this: T =>
}
