package views

import views.behaviours.ViewBehaviours
import views.html.lView

class lViewSpec extends ViewBehaviours {

  "l view" must {

    val view = viewFor[lView](Some(emptyUserAnswers))

    val applyView = view.apply()(fakeRequest, messages)

    behave like normalPage(applyView, "l")

    behave like pageWithBackLink(applyView)
  }
}
