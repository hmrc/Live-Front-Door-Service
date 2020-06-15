package views

import views.behaviours.ViewBehaviours
import views.html.MyNewPageView

class MyNewPageViewSpec extends ViewBehaviours {

  "MyNewPage view" must {

    val view = viewFor[MyNewPageView](Some(emptyUserAnswers))

    val applyView = view.apply()(fakeRequest, messages)

    behave like normalPage(applyView, "myNewPage")

    behave like pageWithBackLink(applyView)
  }
}
