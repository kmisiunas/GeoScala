package com.misiunas.geoscala.transformations

import com.misiunas.geoscala.Point
import breeze.linalg.DenseMatrix

/**
 * User: karolis@misiunas.com
 * Date: 11/08/2013
 * Time: 17:03
 */
trait LinearTransformations[T <: PointDecomposition[T]] extends PointDecomposition[T] {
  this: T =>

  def transform(f: Point => Point): T = constructFromPoints( getPoints.map(f) )

  def transform(matrix: DenseMatrix[Double]): T = {
    if (matrix.rows == 3 && matrix.cols == 3) {
      constructFromPoints( getPoints.map(p => Point.fromDenseVector(matrix * p.toNLP) ) )
    } else throw new IllegalArgumentException("Transformation matrix must be 3x3")
  }

}
