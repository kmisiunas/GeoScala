package surfaces

import org.scalatest.FunSuite
import com.misiunas.geoscala.{Point, DoubleWithAlmostEquals}
import com.misiunas.geoscala.surfaces.{Rectangle, Plane}

/**
 * User: karolis@misiunas.com
 * Date: 23/09/2013
 * Time: 23:26
 */
class SimplePolygonTest extends FunSuite {

  test("Rectangle distance") {
    val r1 = Rectangle(Point(1,0,0), Point(0,0,0), Point(0,3,0))
    println(r1.lines.mkString("\n"))
    assert(r1.distance( Point(1,0,0) ) ~== 0)
    assert(r1.distance( Point(0.5,1,0) ) ~== 0, "ups! r1 = "+r1+", distance= "+r1.distance( Point(0.5,1,0) ))
    assert(r1.distance( Point(0.5,1,1.1) ) ~== 1.1)
    assert(r1.distance( Point(0.5,1,-1.1) ) ~== 1.1, "ups! distance= "+r1.distance( Point(0.5,1,-1.1) ))
    assert(r1.distance( Point(0.5,-1,0) ) ~== 1, "ups! distance= "+r1.distance( Point(0.5,-1,0) ))
    assert(r1.distance( Point(0.5,4,0) ) ~== 1)
    assert(r1.distance( Point(-1,1,0) ) ~== 1)
    assert(r1.distance( Point(2,1,0) ) ~== 1)
    assert(r1.distance( Point(-1,-1,0) ) ~== Math.sqrt(2))
  }

}