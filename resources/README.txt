
                             *** Overview of OODAnimator ***

** Construction of Hierarchy **

    ** model **
    cs5004.animator.model.AnimatorModel (Interface)
                ↑
    cs5004.animator.model.AnimatorModelImpl (class for implementing Interface)


    cs5004.animator.model.IShape (Interface)
                ↑
    cs5004.animator.model.AbstractShape (abstract class that implements IShape)
                ↑
    cs5004.animator.model.Oval (concrete class),
    cs5004.animator.model.Rectangle (concrete class),


    cs5004.animator.model.ITransform (Interface)
                ↑
    cs5004.animator.model.AbstractTransform (abstract class that implements ITransform)
                ↑
    cs5004.animator.model.ChangeColor (concrete class),
    cs5004.animator.model.ChangeScale (concrete class),
    cs5004.animator.model.ChangePos (concrete class)

    ** util **
    cs5004.animator.util.AnimationBuilder (Interface)
                 ↑
    cs5004.animator.util.AnimationBuilderImpl (abstract class that implements  AnimationBuilder)


    cs5004.animator.util.AnimationReader (concrete class)

    ** view **
    cs5004.animator.view.IView (Interface)
                ↑
    cs5004.animator.view.AbstractView (abstract class that implements cs5004.animator.model.IView)
                ↑
    cs5004.animator.view.TextualView (concrete class),
    cs5004.animator.view.SVGView (concrete class),
    cs5004.animator.view.VisualView (concrete class)

    cs5004.animator.view.AnimationPanel (concrete class)

    ** main **
    cs5004.animator.EasyAnimator (Main())


** Description of Interfaces, Abstract Classes, and Concrete Classes **

*   Synopsis of Updates from Assignment 8
- Incorporate starter code AnimationBuilder and AnimationReader and create a AnimationBuilderImpl --
AnimationBuilderImpl is an concrete class implements the Interface AnimationBuilder. It instantiates
a AnimatorModel object with setBounds for a canvas, declaring shapes for an animation, and
adding motions to the animation.

- Create 'View' of the MCV model -- There are 3 types of view for this animator: textualView,
SVGView and, VisualView. These concrete classes extend the AbstractView Class which implements the
IView interface.

- AnimatorModelImpl was updated with additional methods including getters for the attributes of
the canvas, a method that gets the transformed shapes at a particular tick, getters to
access a map of the shape with the animation and a map of the transformation within the
animation, and method to get the appear and disappear time of an object.



*   Interfaces :
- cs5004.animator.model.AnimatorModel -- An interface for the model, it contains methods
to add/store shapes, change a shape's position, color, and scale, and a method to get the
current state of an animation.

- cs5004.animator.model.IShape -- An interface that contains methods to create objects that
represents a 2-D geometric shape (e.g. cs5004.animator.model.Oval
and cs5004.animator.model.Rectangle) in the animation.

- cs5004.animator.model.ITransform -- An interface that supports creating
cs5004.animator.model.ITransform objects which record cs5004.animator.model.IShape object
transformations (e.g. changes color, position or scale). The cs5004.animator.model.ITransform
objects for the animation are stored in the cs5004.animator.model.AnimatorModelImpl within a List.
The interface contains getters for the shape ID  (unique identifier of each
cs5004.animator.model.IShape), the start time of the transformation and the end time of
the transformation.

- cs5004.animator.model.IView  -- An interface that supports creating different types of views
for our animation including textual view, SVG view, and a visual view.


*   Abstract Classes/Class that Implement an Interface :
- cs5004.animator.model.AnimatorModelImpl -- Is a class that implements interface
cs5004.animator.model.AnimatorModel. This class holds a Map which contains a list of all the shapes
in the animation. The Map's key is a String ID and the value is a cs5004.animator.model.IShape
(cs5004.animator.model.Oval, cs5004.animator.model.Rectangle).
Separately, this class also stores a List of transformations (cs5004.animator.model.ChangeColor,
ChangePosition, cs5004.animator.model.ChangeScale) that occur within the animation.

- cs5004.animator.model.AbstractShape -- Is a class that implements
cs5004.animator.model.IShape methods, which contains getters and setters
for a shape's fields. Included are getters for the position each shape
(x,y coordinates),color (r,g,b values), height, width, start time
(shape's appearance in an animation), end time (when a shape disappears in the
animation), and name of a given shape. Currently two concrete classes (cs5004.animator.model.Oval
and  cs5004.animator.model.Rectangle) extend cs5004.animator.model.AbstractShape.

- cs5004.animator.model.AbstractTransform -- Is a class that implements
cs5004.animator.model.ITransform and the Comparable interface which
will allow transformation to be sorted in accordance to the start/end times
within an animation. It also contains a constructor with parameters for a
shape ID, start time and end time of a transformation.

- cs5004.animator.util.AnimationBuilderImpl -- is an abstract class that implements AnimationBuilder
it takes in a model object and instantiates the animation by setting parameters for the canvas,
shapes, and motions.

- cs5004.animator.view.AbstractView -- contains a method to output a animation to either the console
for System.out or to a file is the file's name is given in command line taken in by EasyAnimator.

- cs5004.animator.view.AnimationPanel --  Paints a shape and also refreshes the animation
at each tick to move the object.


*   Concrete Classes :
- cs5004.animator.model.Oval, cs5004.animator.model.Rectangle. These w concrete classes extend
cs5004.animator.model.AbstractShape each has a toString method to describe the shape's fields and a
constructor that calls the super class cs5004.animator.model.AbstractShape.

- cs5004.animator.model.ChangeColor, cs5004.animator.model.ChangeScale,
cs5004.animator.model.ChangePos -- These classes extend the abstract class
cs5004.animator.model.AbstractTransform. Each of the 3 concrete classes has a toString that details
the transformation. Each class's constructor instantiates fields for a shape's initial values and
the values it should become. For example, cs5004.animator.model.ChangePos will change the position
of an object based on its x,y coordinates -- the constructor will contain the starting position
(fromX, fromY) and ending positions (toX, toY). Additionally the constructor calls the super class
cs5004.animator.model.AbstractShape to instantiate the shape ID, start/end time of a transformation.

- cs5004.animator.view.TextualView,cs5004.animator.view.VisualView,cs5004.animator.view.SVGView --
Each concrete class produces a unique representation of the animation either in a textual, SVG,
or visual view.

* Enums :
- cs5004.animator.model.ShapeType -- This class is a enum representing the various types of shapes
supported by this animator (cs5004.animator.model.Oval and cs5004.animator.model.Rectangle).

* Main :
- cs5004.animator.EasyAnimator -- this is the main() which is the entry point for the program.
It takes a command line argument and parses it to read in a file, determine the view type,
assign an output, and set the speed of an animation.


