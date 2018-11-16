using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Payforting.RNPayforting
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNPayfortingModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNPayfortingModule"/>.
        /// </summary>
        internal RNPayfortingModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNPayforting";
            }
        }
    }
}
