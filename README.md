#   GeoScala - Simple Geometry Library for Scala


Warning! This is academic code, ie it is not extensively tested or maintained. 

The library provides 2D/3D vector support for scala. The architecture is designed 
such that it could be extended for geometrical objects and their manipulations. 


### Aims

 - lightweight
 - immutable
 - works with [Breeze](https://github.com/scalanlp/breeze)
 
### Install

In SBT add to `build.sbt`
    
    lazy val g = RootProject(uri("git://github.com/kmisiunas/GeoScala.git"))
   
    lazy val root = project in file(".") dependsOn g

OR if it was published to local SBT repository (via `sbt publish-local`)

    libraryDependencies += "com.misiunas" % "geoscala_2.11" % "0.2.0"


### Usage

Key feature of the library is 3D vector library under Vec()

    import com.misiunas.geoscala.vectors.Vec
    
    val x1 = Vec(1,2,3)
    val x2 = Vec(0,1,0)
    
    x1 + x2 // sum => Vec(1,3,3)
    x1 - x2 // difference => Vec(1,1,3)
    x1 dot x2 // dot product => 2
    x1 cross x2 // cross product => Vec(-3.0, 0.0, 1.0)
    x1 angle x2 // angle between the vectors in rad => 1.006...
    
    x1.vectorLength // length of the vector => 3.74....
    x1.x // first component of the vector => 1.0
    x1.normalise // returns unit vector => Vec(0.2672, 0.53452, 0.80178)
    
    Vec.x // unit vector along X axis => Vex(1.0, 0.0, 0.0)
    
    

### Contribute

Yes, you are welcome to contribute code to the library. Get in touch if you would like to. 

### ToDo

 - [ ] Simplify code base
 - [X] Add description for downloading from GitHub server
 - [ ] Performance tests
 - [ ] Fix return type inheritance problems 

