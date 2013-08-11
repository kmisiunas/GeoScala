package com.misiunas.geoscala.vectors

/**
 * == A representation of 3D vector ==
 *
 * These vectors ar column. Row vectors will be represented as matrices.
 *
 * Library is numerical, it will not perform simplifications - might be changed in future.
 *
 * todo: Type system should be improved
 *
 *
 * User: karolis@misiunas.com
 * Date: 11/08/2013
 * Time: 02:07
 */
trait Vector3DLike[T <: Vector3DLike[T]] {
  this: T =>

  // ------------ Implementations needed ------------

  /** constructs new type from specified values */
  protected def makeFrom(e1: Double, e2: Double, e3: Double): T

  def x: Double
  def y: Double
  def z: Double

  def toString: String

  // todo def toLaTeX: String?

  // ------------ Access methods ------------

  def e1 = x    // another common notation
  def e2 = y
  def e3 = z

  def apply(i: Int): Double = i match {
    case 1 => x
    case 2 => y
    case 3 => z
    case _ => throw new IndexOutOfBoundsException("This vector only supports access to elements {1,2,3}")
  }

  def toList: List[Double] = List(x,y,z)

  /** is this vector a column vector */
  def isColumn: Boolean = true

  /** is this vector a row vector */
  def isRow: Boolean = false

  def isZero: Boolean = this == makeFrom(0,0,0)

  // ---------- Other -----------

  override def equals(any: Any): Boolean = any match {
    case t: Vector3DLike[T] => t.x == x && t.y == y && t.z == z // unnecessary?
    case _ => false
  }

  // ---------- Common Maths Manipulations ---------

  /** Vector addition */
  def + (that: T): T = makeFrom(that.x+x, that.y+y, that.z+z)

  /** minus sign in front of a vector - flip direction */
  def unary_- : T = makeFrom(-x,-y,-z)

  /** element wise multiplication */
  def :* (that: T): T = makeFrom(that.x*x, that.y*y, that.z*z)

  /** multiplications with a scalar */
  def :* (d: Double): T = makeFrom(d*x, d*y, d*z)

  /** vector dot product */
  def dot (that: T): Double = that.x*x + that.y*y + that.z*z

  /** vector cross product */
  def cross (that: T): T = makeFrom(y*that.z - z*that.y, z*that.x - x*that.z, x*that.y - y*that.x)

  // ---------- Derivative manipulations -------

  /** Returns the difference between vectors */
  def - (that: T): T = this + (-that)

  def * (d: Double): T = this :* d
  def *: (d: Double): T = this :* d

  /** returns number of elements in this vector */
  def size: Int = 3

  /** the length of this vector */
  @deprecated("Warning: .length is not compatible with Breeze NL.")
  def length: Double = vectorLength

  def vectorLength: Double = Math.sqrt(x*x + y*y + z*z)

  def normalise: T  = this * (1/vectorLength)


}
