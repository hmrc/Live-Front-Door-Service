package views

import views.behaviours.ViewBehaviours
import views.html.OccurenceHistoryView

class OccurenceHistoryViewSpec extends ViewBehaviours {

  "OccurenceHistory view" must {

    val view = viewFor[OccurenceHistoryView](Some(emptyUserAnswers))

    val applyView = view.apply()(fakeRequest, messages)

    behave like normalPage(applyView, "occurenceHistory")

    behave like pageWithBackLink(applyView)
  }
}
