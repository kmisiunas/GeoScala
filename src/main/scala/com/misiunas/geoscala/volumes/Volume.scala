package com.misiunas.geoscala.volumes

import com.misiunas.geoscala.{Point, Feature}

/**
 * == A Volume ==
 *
 * User: karolis@misiunas.com
 * Date: 10/08/2013
 * Time: 21:32
 */
trait Volume extends Feature {

/** is the point within the volume element? */
def isWithin(p: Point) : Boolean

}