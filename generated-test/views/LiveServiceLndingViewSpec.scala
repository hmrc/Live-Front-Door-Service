package views

import views.behaviours.ViewBehaviours
import views.html.LiveServiceLndingView

class LiveServiceLndingViewSpec extends ViewBehaviours {

  "LiveServiceLnding view" must {

    val view = viewFor[LiveServiceLndingView](Some(emptyUserAnswers))

    val applyView = view.apply()(fakeRequest, messages)

    behave like normalPage(applyView, "liveServiceLnding")

    behave like pageWithBackLink(applyView)
  }
}
