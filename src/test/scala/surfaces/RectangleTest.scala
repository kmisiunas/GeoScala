package surfaces

import org.scalatest.FunSuite
import com.misiunas.geoscala.Point
import com.misiunas.geoscala.surfaces.{Rectangle, Plane}

/**
 * User: karolis@misiunas.com
 * Date: 23/09/2013
 * Time: 17:33
 */
class RectangleTest extends FunSuite {

  val p1 = Point(1.1,2.2,3.3)
  val p2 = Point(3,2,1)
  val p3 = Point(1,0,0)
  val p4 = Point(0,0,0)
  val p5 = Point(0,1,0)
  val p6 = Point(0,3,0)

  val planeXY = Plane(p3,p4,p5)

  test("Rectangle.apply") {
    var r: Rectangle  = null
    try{
      r = Rectangle.apply(Point(1,0,0), Point(0,0,0),Point(0,2,0))
    }
    assert(r != null)
    var r2: Rectangle = null
    try{
      r2 = Rectangle.apply(Point(1,0,0), Point(0,1,0),Point(0,2,2))
    } catch {
      case e:Exception => ()
    }
    assert(r2 eq null, r2)

  }


}