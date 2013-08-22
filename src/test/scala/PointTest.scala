import com.misiunas.geoscala.Point
import org.scalatest.FunSuite

/**
 * User: karolis@misiunas.com
 * Date: 23/07/2013
 * Time: 16:02
 */
class PointTest extends FunSuite {

  def approx(d1 :Double, d2:Double, acc: Double = 0.0001) : Boolean = (Math.abs(d1-d2)<acc)

  val p1 = Point(1.1,2.2,3.3)
  val p2 = Point(3,2,1)
  val p3 = Point(1,4,2)
  val p4 = Point(2,2,0)
  val p5 = Point(4,0,0)
  val p6 = Point(0,3,0)

  test("Point.equals") {
    assert(p1 == Point(1.1,2.2,3.3))
    assert(p1 != Point(1.2,2.2,3.3))
  }

  test("Point maths operations") {
    assert((p2 dot p3) == 13)
    assert((p2 cross p3) == Point(0,-5,10))
    assert((p2 + p3) == Point(4,6,3))
    assert((-p3) == Point(-1,-4,-2))
    assert((p2 - p3) == Point(2,-2,-1))
    assert((p2 * 2) == Point(6,4,2))
    assert((2 *: p2) == Point(6,4,2))
    assert((p4.normalise) == ((1/Math.sqrt(2)) *: Point(1,1,0)),"Failed to normalize: "+ (p4.normalise))
  }

  test("Point.distance") {
    assert(p5.distance(p6) == 5, "Distance test = "+ p5.distance(p6) + ", expected 5")
  }

  test("Point operator priority: multiplication with scalar") {
    assert(p1 - p2 * 10 == p1 - (p2 * 10))
    assert(-p2 * 10 + p1 == p1 - (p2 * 10))
  }

}
