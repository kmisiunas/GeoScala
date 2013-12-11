import com.misiunas.geoscala.{Line, Point, DoubleWithAlmostEquals}
import org.scalatest.FunSuite

/**
 * User: karolis@misiunas.com
 * Date: 24/09/2013
 * Time: 00:36
 */
class LineTest extends FunSuite {

  val l1 = Line( Point(0,0), Point(1,0))

  test("Line.distance") {
    assert(l1.distance( Point(0) ) ~== 0)
    assert(l1.distance( Point(1) ) ~== 0)
    assert(l1.distance( Point(0.5) ) ~== 0)
    assert(l1.distance( Point(-1) ) ~== 1)
    assert(l1.distance( Point(2) ) ~== 1)
    assert(l1.distance( Point(0.5,2) ) ~== 2, "ups! distance = "+l1.distance( Point(0.5,2) ))
    assert(l1.distance( Point(0.5,-2) ) ~== 2)
    assert(l1.distance( Point(-1,-1) ) ~== Math.sqrt(2))
  }



}
