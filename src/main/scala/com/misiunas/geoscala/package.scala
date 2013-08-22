package com.misiunas

import org.apache.commons.math3.util.Precision

/**
 * User: karolis@misiunas.com
 * Date: 21/08/2013
 * Time: 18:03
 */
package object geoscala {

  val doubleComparisonsPrecision: Double = Double.MinPositiveValue * 10

  /** Implicit approximate comparison between two Doubles - nessesary for numerical computations */
  implicit class DoubleWithAlmostEquals(val d:Double) extends AnyVal {
    def ~==(d2:Double) = (d - d2).abs < doubleComparisonsPrecision
  }

}
