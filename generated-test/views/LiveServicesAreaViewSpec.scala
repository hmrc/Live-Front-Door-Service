package views

import views.behaviours.ViewBehaviours
import views.html.LiveServicesAreaView

class LiveServicesAreaViewSpec extends ViewBehaviours {

  "LiveServicesArea view" must {

    val view = viewFor[LiveServicesAreaView](Some(emptyUserAnswers))

    val applyView = view.apply()(fakeRequest, messages)

    behave like normalPage(applyView, "liveServicesArea")

    behave like pageWithBackLink(applyView)
  }
}
