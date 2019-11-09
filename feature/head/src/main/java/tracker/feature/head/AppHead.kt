package tracker.feature.head

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.sha.apphead.AppHead
import com.sha.apphead.Head
import com.sha.kamel.navigator.modular.ActivityModuleNavigator
import restaurants.feature.head.R
import tracker.common.core.CoreApp
import tracker.common.presentation.navigation.Activities

object AppHead {

    @JvmStatic
    fun show(activity: FragmentActivity) {
        val builder = Head.Builder(R.mipmap.ic_launcher)
                .loadHeadImage {
                    it.layoutParams.width = 200
                    it.layoutParams.height = 200
                }
                .onClick {
                    ActivityModuleNavigator(activity, activity.packageName)
                            .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            .navigate(Activities.Main)
                }
        AppHead(builder).show(activity)
    }

    fun hide() {
        AppHead.hide(CoreApp.context)
    }

}