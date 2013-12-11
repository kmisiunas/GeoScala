package surfaces

import org.scalatest.FunSuite
import com.misiunas.geoscala.Point
import com.misiunas.geoscala.surfaces.Plane

/**
 * User: karolis@misiunas.com
 * Date: 21/08/2013
 * Time: 16:23
 */
class PlaneTest extends FunSuite {

  val p1 = Point(1.1,2.2,3.3)
  val p2 = Point(3,2,1)
  val p3 = Point(1,0,0)
  val p4 = Point(0,0,0)
  val p5 = Point(0,1,0)
  val p6 = Point(0,3,0)

  val planeXY = Plane(p3,p4,p5)

  test("Plane.normal") {
    assert(planeXY.normal == Point(0,0,1))
  }

  test("Plane.project") {
    assert(planeXY.project(Point(0,0,1)) == Point(0,0,0))
    assert(planeXY.project(Point(1,1,-1)) == Point(1,1,0), "ups! projected Point(1,1,-1) = " + planeXY.project(Point(1,1,-1)))
  }

}
