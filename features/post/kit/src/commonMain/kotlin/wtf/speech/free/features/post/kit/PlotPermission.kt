package wtf.speech.free.features.post.kit

public sealed class PlotPermission {
    public data object ForSubscribed : PlotPermission()
    public data object ForSubscribersAndSubscribed : PlotPermission()
    public data object ForMentioned : PlotPermission()
    public data object ForEveryone : PlotPermission()
}
