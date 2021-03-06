package org.sylfra.idea.plugins.xstructure;

import com.intellij.CommonBundle;
import com.intellij.reference.SoftReference;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.util.ResourceBundle;

/**
 * Provides convenient methods to retrieve labels from bundles declared in plugin conf
 *
 * @author <a href="mailto:sylfradev@yahoo.fr">Sylvain FRANCOIS</a>
 * @version $Id: XSMessageManager.java 31 2007-12-23 11:23:10Z syllant $
 */
public class XSMessageManager
{
  private static Reference<ResourceBundle> pluginBundle;

  @NonNls
  private static final String BUNDLE =
    "org.sylfra.idea.plugins.xstructure.resources.XSBundle";

  /**
   * Returns the message got the specified key, formatted with specified params
   *
   * @param key    the message key
   * @param params the message parameters
   *
   * @return the formatted message
   */
  public static String message(@PropertyKey(resourceBundle = BUNDLE)String key, Object... params)
  {
    return CommonBundle.message(getBundle(), key, params);
  }

  /**
   * Returns the message got the specified key
   *
   * @param key the message key
   *
   * @return the formatted message
   */
  public static String message(@PropertyKey(resourceBundle = BUNDLE)String key)
  {
    return message(key, new Object[]{});
  }

  private static ResourceBundle getBundle()
  {
    ResourceBundle bundle = null;
    if (pluginBundle != null)
    {
      bundle = pluginBundle.get();
    }
    if (bundle == null)
    {
      bundle = ResourceBundle.getBundle(BUNDLE);
      pluginBundle = new SoftReference<ResourceBundle>(bundle);
    }
    return bundle;
  }
}
