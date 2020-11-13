import com.sun.org.apache.bcel.internal.classfile.ConstantValue

def title(text: String, anchor: String, style: String): String =
  s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"

title("chap:vcls", "bold", "Value Classes")

class Text(val text: String) extends AnyVal

class Anchor(val text: String) extends AnyVal

class Style(val text: String) extends AnyVal

class Html(val text: String) extends AnyVal

def title2(text: Text, anchor: Anchor, style: Style): Html = {
  new Html(s"<a id ='$anchor> + " +
    s"<h1 class='$style'> + " +
    s"$text</h1></a>"
  )
}

new Anchor("chap:vcls")

title2(new Text("Value Classes"), new Anchor("chap:vcls"),new Style("bold"))