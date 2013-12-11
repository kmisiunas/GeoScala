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