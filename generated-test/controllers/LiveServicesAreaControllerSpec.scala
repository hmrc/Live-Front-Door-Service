package controllers

import base.SpecBase
import play.api.test.FakeRequest
import play.api.test.Helpers._
import views.html.LiveServicesAreaView

class LiveServicesAreaControllerSpec extends SpecBase {

  "LiveServicesArea Controller" must {

    "return OK and the correct view for a GET" in {

      val application = applicationBuilder(userAnswers = Some(emptyUserAnswers)).build()

      val request = FakeRequest(GET, routes.LiveServicesAreaController.onPageLoad().url)

      val result = route(application, request).value

      val view = application.injector.instanceOf[LiveServicesAreaView]

      status(result) mustEqual OK

      contentAsString(result) mustEqual
        view()(fakeRequest, messages).toString

      application.stop()
    }
  }
}
