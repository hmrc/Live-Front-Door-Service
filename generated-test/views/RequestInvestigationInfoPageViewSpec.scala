package views

import views.behaviours.ViewBehaviours
import views.html.RequestInvestigationInfoPageView

class RequestInvestigationInfoPageViewSpec extends ViewBehaviours {

  "RequestInvestigationInfoPage view" must {

    val view = viewFor[RequestInvestigationInfoPageView](Some(emptyUserAnswers))

    val applyView = view.apply()(fakeRequest, messages)

    behave like normalPage(applyView, "requestInvestigationInfoPage")

    behave like pageWithBackLink(applyView)
  }
}
